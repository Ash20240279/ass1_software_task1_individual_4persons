
public class Main {

    public static void main(String[] args) {


        TasbeehCounter tasbeeh = new TasbeehCounter();


        tasbeeh.incrementSubhan(); tasbeeh.incrementSubhan(); tasbeeh.incrementSubhan();
        tasbeeh.incrementHamd();
        tasbeeh.incrementAkbar();

        tasbeeh.incrementAkbar();

        tasbeeh.incrementAkbar();



        tasbeeh.incrementAkbar();

        tasbeeh.incrementAkbar();


        System.out.println("Subhan Allah: " + tasbeeh.getSubhanCount());
        System.out.println("Alhamdulillah: " + tasbeeh.getHamdCount());
        System.out.println("Allahu Akbar: " + tasbeeh.getAkbarCount());
        System.out.println("Total: " + tasbeeh.getTotalCount());
        tasbeeh.resetAll();
    }
}
























































































