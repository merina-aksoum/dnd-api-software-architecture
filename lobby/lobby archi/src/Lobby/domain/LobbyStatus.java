package Lobby.domain;

public enum LobbyStatus {
        WAITING("Waiting"),
        STARTED("Started"),
        FINISH("Finished"),
        INGAME("In Game"),;

        private final String status;

        LobbyStatus(String status){
                this.status = status;
        }
        public String getStatus(){
                return this.status;
        }


}
