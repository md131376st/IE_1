
class ReqUser {


    private Register userREQ;
    private int bidAmount ;

    ReqUser(Register userREQ, int bidAmount) {
        this.userREQ = userREQ;
        this.bidAmount = bidAmount;
    }

    Register getUserREQ() {
        return userREQ;
    }

    int getBidAmount() {
        return bidAmount;
    }
}
