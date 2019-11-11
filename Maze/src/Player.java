public class Player {
    private static Player thePlayer;

    private Player(){

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
