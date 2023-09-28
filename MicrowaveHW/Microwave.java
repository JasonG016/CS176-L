package MicrowaveHW;

class Microwave {
    private int powerLevel;
    private int time;

    public Microwave() {
        powerLevel = 1;
        time = 0;
    }

    public void timeButton() {
        time += 30;
        System.out.println("Time Button was pressed. Time is " + time + " seconds");
    }

    public void powerButton() {
        powerLevel++;
        System.out.println("Power Button was pressed. Power level is " + powerLevel);
    }

    public void resetButton() {
        powerLevel = 1;
        time = 0;
        System.out.println("Reset Button was pressed. Power level is 1. Time is 0 seconds.");
    }

    public void startButton() {
        System.out.println("Cooking for " + time + " seconds at level " + powerLevel + ".");
    }
}
