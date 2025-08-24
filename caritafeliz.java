public class caritafeliz {
    public static void main(String[] args) throws InterruptedException {
        String[] faces = {":D", ":)"};
        System.out.println("Hola mundo");
        for (int i = 0; i < 10; i++) {
            System.out.print("\r" + faces[i % 2]);
            Thread.sleep(500);
        }
        System.out.println();
    }
}