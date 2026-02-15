package shahzadCode.javaOOP.interfaceClass;

 interface playable {
    void play();
}

interface Recordable{
     void record();
}

class   Musicplayer implements playable, Recordable{

    @Override
    public void play() {
        System.out.println(" I can play Music");
    }

    @Override
    public void record() {
        System.out.println(" I can play Videos");

    }
}

public class InterfaceDemo{
    public static void main(String[] args) {
        Musicplayer mp = new Musicplayer();

        mp.play();
    }
}
