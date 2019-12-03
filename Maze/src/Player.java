public class Player {
    private static Player thePlayer;

    public Player(){

    }
    public static Player getPlayer(){
        // use of singleton to return the player
        if(thePlayer == null){
            return new Player();
        }else{
            return thePlayer;
        }
    }

}
