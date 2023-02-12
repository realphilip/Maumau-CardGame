
    public class GameInitializationException extends Exception{
        /**
         * An undefined error is thrown with a generalized initialization message.
         */
        public GameInitializationException(){
            super("Theres been an error initializing the game. Please contact the developers at github.com/realphilip/maumau-cardgame");
        }

        /**
         *  This method throws a defined exception when there is a specific problem at the start of the game.
         * @param error - the parameter-specified error message
         */
        public GameInitializationException(String error){
            super(error);
        }
    }


