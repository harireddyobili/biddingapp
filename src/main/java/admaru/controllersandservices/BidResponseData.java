package admaru.controllersandservices;


import java.util.List;

import java.util.List;



public class BidResponseData {
    public static class Id {
        private long timestamp;
        private String date;

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    public static class Bid {
        private String id;
        private String impid;
        private double price;
        private String dealid;
        private String nurl;
        private List<String> adomain;
        private String iurl;
        private String cid;
        private String crid;
        private String adid;
        private List<Integer> attr;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImpid() {
            return impid;
        }

        public void setImpid(String impid) {
            this.impid = impid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getDealid() {
            return dealid;
        }

        public void setDealid(String dealid) {
            this.dealid = dealid;
        }

        public String getNurl() {
            return nurl;
        }

        public void setNurl(String nurl) {
            this.nurl = nurl;
        }

        public List<String> getAdomain() {
            return adomain;
        }

        public void setAdomain(List<String> adomain) {
            this.adomain = adomain;
        }

        public String getIurl() {
            return iurl;
        }

        public void setIurl(String iurl) {
            this.iurl = iurl;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getCrid() {
            return crid;
        }

        public void setCrid(String crid) {
            this.crid = crid;
        }

        public String getAdid() {
            return adid;
        }

        public void setAdid(String adid) {
            this.adid = adid;
        }

        public List<Integer> getAttr() {
            return attr;
        }

        public void setAttr(List<Integer> attr) {
            this.attr = attr;
        }
    }

    public static class SeatBid {
        private String seat;
        private List<Bid> bid;

        public String getSeat() {
            return seat;
        }

        public void setSeat(String seat) {
            this.seat = seat;
        }

        public List<Bid> getBid() {
            return bid;
        }

        public void setBid(List<Bid> bid) {
            this.bid = bid;
        }
    }

    private Id _id;
    private String id;
    private String bidid;
    private String cur;
    private List<SeatBid> seatbid;

    public Id get_id() {
        return _id;
    }

    public void set_id(Id _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBidid() {
        return bidid;
    }

    public void setBidid(String bidid) {
        this.bidid = bidid;
    }

    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur;
    }

    public List<SeatBid> getSeatbid() {
        return seatbid;
    }

    public void setSeatbid(List<SeatBid> seatbid) {
        this.seatbid = seatbid;
    }
}
