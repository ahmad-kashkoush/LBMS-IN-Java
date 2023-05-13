public class Book {
    String BookName , Category;
    int NumberOfPages , Quantity , ID;
    public void SetBookName(String BookName){
        this.BookName=BookName;
    }
    public void setID(int ID){
        this.ID=ID;
    }
    public void setNumberOfPages(int NumberOfPages){
        this.NumberOfPages=NumberOfPages;
    }
    public void setQuantity(int Quantity){
        this.Quantity=Quantity;
    }
    public void SetCategory(String Category){
        this.Category=Category;
    }
    public String getBookName(){
        return BookName;
    }
    public int getId(){
        return ID;
    }
    public int  getNumberOfPages(){
        return NumberOfPages;
    }
    public int getQuantity(){
        return Quantity;
    }
    public String getCategory(){
        return Category;
    }
    public static void main(String [] args){

    }
}