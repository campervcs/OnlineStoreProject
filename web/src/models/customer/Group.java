package models.customer;
import java.util.ArrayList;
import java.util.List;

public class Group {
    List<Customer> customerList = new ArrayList<>();
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public void joinCustomer(Customer customer){
        customerList.add(customer);
    }
}
