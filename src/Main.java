public class Main {
    public static void main(String[] args) {
        String re;
        Program program = new Program();
        do {
            program.output();
            System.out.print("Again (y/n): ");
            re = IOUtil.readString();
        } while (!re.equals("n"));
        System.out.print("END.");
    }
}
