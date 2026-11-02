import java.io.*;
import java.util.*;

public class TodoApp {

    // 任务列表，每个任务是一个字符串数组：[状态, 内容]
    // 状态："0" 未完成，"1" 已完成
    static List<String[]> tasks = new ArrayList<>();
    static final String FILE_NAME = "tasks.txt";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadTasks();

        while (true) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    listTasks();
                    break;
                case "3":
                    completeTask();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    saveTasks();
                    System.out.println("已保存，再见！");
                    return;
                default:
                    System.out.println("无效输入，请输入 1～5。");
            }
        }
    }

    // 显示菜单
    static void showMenu() {
        System.out.println("\n===== 待办清单 =====");
        System.out.println("1. 添加任务");
        System.out.println("2. 查看所有任务");
        System.out.println("3. 完成任务");
        System.out.println("4. 删除任务");
        System.out.println("5. 退出");
        System.out.print("请选择：");
    }

    // 添加任务
    static void addTask() {
        System.out.print("输入任务内容：");
        String content = scanner.nextLine();
        if (content.trim().isEmpty()) {
            System.out.println("任务内容不能为空。");
            return;
        }
        tasks.add(new String[]{"0", content});
        System.out.println("已添加：" + content);
        saveTasks();
    }

    // 查看所有任务
    static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("暂无任务。");
            return;
        }
        System.out.println("\n任务列表：");
        for (int i = 0; i < tasks.size(); i++) {
            String[] t = tasks.get(i);
            String mark = t[0].equals("1") ? "[✓]" : "[ ]";
            System.out.println((i + 1) + ". " + mark + " " + t[1]);
        }
    }

    // 完成任务
    static void completeTask() {
        listTasks();
        if (tasks.isEmpty()) return;

        System.out.print("输入要完成的任务编号：");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= tasks.size()) {
                System.out.println("编号无效。");
                return;
            }
            tasks.get(index)[0] = "1";
            System.out.println("已完成：" + tasks.get(index)[1]);
            saveTasks();
        } catch (NumberFormatException e) {
            System.out.println("请输入数字。");
        }
    }

    // 删除任务
    static void deleteTask() {
        listTasks();
        if (tasks.isEmpty()) return;

        System.out.print("输入要删除的任务编号：");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= tasks.size()) {
                System.out.println("编号无效。");
                return;
            }
            String removed = tasks.remove(index)[1];
            System.out.println("已删除：" + removed);
            saveTasks();
        } catch (NumberFormatException e) {
            System.out.println("请输入数字。");
        }
    }

    // 从文件读取任务
    static void loadTasks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 2);
                if (parts.length == 2) {
                    tasks.add(new String[]{parts[0], parts[1]});
                }
            }
        } catch (IOException e) {
            System.out.println("读取文件失败：" + e.getMessage());
        }
    }

    // 保存任务到文件
    static void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String[] t : tasks) {
                writer.write(t[0] + "|" + t[1]);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("保存文件失败：" + e.getMessage());
        }
    }
}