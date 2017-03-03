class OBS{
    float x_coord, y_coord, z_coord, log_dest, lat_dest;
    double speed;
    void setPosition(float x_coord, float y_coord, float z_coord){
      //user input sets aircrafts location in the sky  
    }
    void setDestination(float log_dest, float lat_dest){
        //user input sets destination via longitude and latitiude
    }
    void setSpeed(){
        //sets speed, not sure if we need this yet
    }
    float getXPosition(){
        //returns X postion
    }
    float getYPosition(){
        //returns Y postion
    }
    float getZPosition(){
        //returns Z postion
    }
    float getLong(){
        //returns longitude
    }
    float getLat(){
        // returns latitiude
    }
    double getSpeed(){
        //returns speed
    }
}
class radio{
    float x_coord, y_coord;
    double signalRange, intercept;
    void setPosition(){
        //sets position of radio
    }
    void setRange(){
        //sets the range of radio signal
    }
    void calcRadial(){
        //determines radial
    }
    float getXPosition(){
        //returns x postition
    }
    float getYPosition(){
        //returns y postition
    }
    float getRadial{
        //returns intecept
    }
}
class VOR{
    float craftXpos, craftYpos, craftZpos, log_dest, lat_dest, radioXpos, radioYpos, distance;
    double speed, signalRange, defelection;
    int signal; //0=bad, 1=good
    double heading; //0=left, 1=right
    OBS obs = new OBS();
    radio fake_radio = new radio();
    
    setCraft(){
        //calls OBS getters to orient craft
        //set speed
    }
    setRadio(){
        //sets radio with radio getters
    }
    float calcDistance(){
        //uses craft position and radio location to calc distance
    }
    int signal(){
        //uses distance and signalRange to determine if signal is GOOD or BAD
    }
    deflection(){
        //calcuated deflection based off OBS and radio
    }
    int getHeading(){
        //returns heading left/right via binary
    }
    double getDeflection(){
        //returns double between 0 and 359
    }
}

