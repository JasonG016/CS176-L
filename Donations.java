package DonationsHW;

public class Donations {
    private int numIndividual;
    private double amtIndividual;
    private int numBusiness;
    private double amtBusiness;
    private int numOther;
    private double amtOther;

    public Donations() {
        numIndividual = 0;
        amtIndividual = 0;
        numBusiness = 0;
        amtBusiness = 0;
        numOther = 0;
        amtOther = 0;
    }

    public void processDonation(String cat, Double donation) {
        if (cat.equalsIgnoreCase("individual")) {
            numIndividual++;
            amtIndividual += donation;
        } else if (cat.equalsIgnoreCase("business")) {
            numBusiness++;
            amtBusiness += donation;
        } else if (cat.equalsIgnoreCase("other")) {
            numOther++;
            amtOther += donation;
        }

        System.out.println(cat + " donation amount: " + donation);
    }

    public void getStatistics() {
        System.out.println("Individual: #:" + numIndividual + " $" + amtIndividual);
        System.out.println("Business: #:" + numBusiness + " $" + amtBusiness);
        System.out.println("Other: #:" + numOther + " $" + amtOther);
    }
}
