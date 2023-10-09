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

    public void processDonation(String cat, double donation) {
        if ("individual donation".equals(cat)) {
            numIndividual++;
            amtIndividual += donation;
        } else if ("business donation".equals(cat)) {
            numBusiness++;
            amtBusiness += donation;
        } else if ("other donation".equals(cat)) {
            numOther++;
            amtOther += donation;
        }

       
    }

    

    public void getStatistics() {
        System.out.println("Individual: #:" + numIndividual + " $" + amtIndividual);
        System.out.println("Business: #:" + numBusiness + " $" + amtBusiness);
        System.out.println("Other: #:" + numOther + " $" + amtOther);
    }
}
