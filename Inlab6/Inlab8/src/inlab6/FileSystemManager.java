package inlab6;

import java.util.Scanner;

/**
 *
 * @author yaw
 */
public class FileSystemManager {

    private FileTree tree;

    public FileSystemManager() {
        tree = new FileTree();
    }

    public void run() {
        tree.insert("School");
        tree.insert("Skiing");
        tree.insert("Work");
        tree.insert("Personal");
        tree.moveDown("School");
        tree.insert("CSCI111");
        tree.insert("CSCI132");
        tree.moveDown("CSCI132");
        tree.insert("Inlabs");
        tree.goHome();
        tree.moveDown("Skiing");
        tree.insert("Pictures");
        tree.insert("Trips");
        tree.insert("Gear");
        tree.moveDown("Trips");
        tree.insert("Summer");
        tree.insert("Winter");
        tree.moveDown("Summer");
        tree.insert("Tetons");
        tree.insert("AK");
        tree.goHome();
        tree.moveDown("Work");
        tree.insert("Reviews");
        tree.insert("Paystubs");
        tree.moveDown("Paystubs");
        tree.insert("2014");
        tree.insert("2015");
        tree.goHome();
        tree.moveDown("Personal");
        tree.insert("Resume");
        tree.insert("Taxes");
        tree.goHome();
        String command = " ";
        Scanner in = new Scanner(System.in);
        while (!command.equals("exit")) {
            System.out.print(tree.getLocation() + "> ");
            command = in.nextLine();
            executeCommand(command);
        }
    }

    private void executeCommand(String command) {
        int breakPoint = command.indexOf(" ");
        String argument = null;
        if (breakPoint != -1) {
            argument = command.substring(breakPoint + 1, command.length());
            command = command.substring(0, breakPoint);
        }

        if (command.equals("cd")) { //Change Directory
            if (!move(argument)) {
                System.out.println("File not found.\n");
            }
        } else if (command.equals("ls")) { //Prints Children
            System.out.println(tree.getChildren() + "\n");
        } else if (command.equals("mkdir")) { //Makes a directory mkdir, Creates new File
            if (!tree.insert(argument)) {
                System.out.println("Invalid file name.\n");
            }
        } else if (command.equals("rm")) { //Remove Directory
            if (!tree.remove(argument)) {
                System.out.println("File not found.\n");
            }
        } else if (command.equals("tree")) {
            System.out.println(tree.getSubTree());
        } else if (command.equals("exit")) {

        } else {
            System.out.println("'" + command + "' is not a recognized command");
        }
    }

    private boolean move(String file) {
        if (file == null) {
            return false;
        }

        if (file.equals("~")) {
            tree.goHome();
            return true;
        }

        if (file.equals("..")) { //
            tree.moveUp();
            return true;
        }

        return tree.moveDown(file);
    }
}
