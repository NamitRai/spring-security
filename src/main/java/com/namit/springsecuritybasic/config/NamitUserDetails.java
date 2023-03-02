package com.namit.springsecuritybasic.config;

import com.namit.springsecuritybasic.entity.Customer;
import com.namit.springsecuritybasic.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NamitUserDetails implements UserDetailsService {

    @Autowired
    CustomerRepo customerRepo ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String user,password = null;
        List<GrantedAuthority> grantedAuthorityList = null;
        List<Customer> customers = customerRepo.findByEmail(username);

        if(customers.size()==0){
            throw new UsernameNotFoundException("user is not found in db "+username);
        }
        else{
            user = customers.get(0).getEmail();
            password = customers.get(0).getPwd();
            grantedAuthorityList = new ArrayList<>() ;
            grantedAuthorityList.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        }
        return new User(user,password,grantedAuthorityList);
    }
}
