public class CustomerService 
{
    CustomerRepository customerRepository;
    
    CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(int id)
    {
        return customerRepository.findCustomerById(id);
    }
}
