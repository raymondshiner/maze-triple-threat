public class Program {
    public static void main(String [] args)
    {
        //MultipleChoice tmp = new MultipleChoice();

        Door up = new Door();
        up.lock();

        Door down = new Door();
        down.open();

        Wall left = new Wall();
        Door right = new Door();

        Room room = new Room(up, down, right, left);

        room.displayRoom();
    }
}
