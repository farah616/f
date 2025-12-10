import java.lang.Exception;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
enum Status{
     In_Progress, Completed, Cancelled
}

public class Task implements Runnable{
    Thread thread;
public Task(){
    thread=new Thread(this);
}
    private int id;
    private String productName;
    private Product product;
    private int productQuantity;
    private ArrayList<Product> productscompleted=new ArrayList<>();

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    private String client;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;
    private ProductLine assignedLine;
    private double percentageOfCompletion;
    public int getId() {
        return id;
    }
    public String getProductName() {
        return productName;
    }

    public Product getProduct() {
        return product;
    }

    public int getproductQuantity() {
        return productQuantity;
    }

    public String getClient() {
        return client;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ProductLine getAssignedLine() {
        return assignedLine;
    }

    public double getPercentageOfCompletion() {
        if(productQuantity==0)
            return 0.0;
        else
            return ((double)getnumberofProductcompleted()/productQuantity)*100;
    }
    public int getnumberofProductcompleted(){
        return productscompleted.size();
    }

    public Task(int id, String productName, Product product, int productQuantity, String client, Status status, LocalDate startDate, LocalDate endDate, ProductLine assignedLine) {
        this.id = id;
        this.productName = productName;
        this.product = product;
        this.productQuantity = productQuantity;
        this.client = client;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.assignedLine = assignedLine;
    }
    public void taskStatus(){
        if (getStatus()==Status.Completed)
            System.out.println("Task is completed");
       else if (getStatus()==Status.In_Progress)
            System.out.println("Task is In_Progress");
       else
            System.out.println("Task is Cancelled");
    }

   /* boolean checkItem(Item item,int requiredquantity) throws ItemException {
        if (item.getQuantity()-requiredquantity >= item.getMinimum_allowe())
            return true;
        else
           throw new ItemException("not enough items in storge");
    }*/
   public void addProductcompleted(Storage storage,Product product) {
       Product existingProduct = storage.findProductByName(product.getname());
       if (existingProduct != null) {
          int uptadeQuantity=storage.getQuantityofproductstorage(product)+getproductQuantity();
          storage.Quantityofproductstorage(product,uptadeQuantity);
       } else {
           storage.addProduct(product);
       }
   }
   public void getItemForProduct(Storage storage,Product product,Item item ,int requiredquantity)
   {
       storage.ItemForProduct(item ,requiredquantity);
    
   }
    @Override
    public void run() {

    }


}
