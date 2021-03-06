package model;
// Generated Apr 16, 2018 10:03:05 PM by Hibernate Tools 4.3.1



/**
 * SeatId generated by hbm2java
 */
public class SeatId  implements java.io.Serializable {


     private String seatPosition;
     private int studioNumber;

    public SeatId() {
    }

    public SeatId(String seatPosition, int studioNumber) {
       this.seatPosition = seatPosition;
       this.studioNumber = studioNumber;
    }
   
    public String getSeatPosition() {
        return this.seatPosition;
    }
    
    public void setSeatPosition(String seatPosition) {
        this.seatPosition = seatPosition;
    }
    public int getStudioNumber() {
        return this.studioNumber;
    }
    
    public void setStudioNumber(int studioNumber) {
        this.studioNumber = studioNumber;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SeatId) ) return false;
		 SeatId castOther = ( SeatId ) other; 
         
		 return ( (this.getSeatPosition()==castOther.getSeatPosition()) || ( this.getSeatPosition()!=null && castOther.getSeatPosition()!=null && this.getSeatPosition().equals(castOther.getSeatPosition()) ) )
 && (this.getStudioNumber()==castOther.getStudioNumber());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSeatPosition() == null ? 0 : this.getSeatPosition().hashCode() );
         result = 37 * result + this.getStudioNumber();
         return result;
   }   


}


