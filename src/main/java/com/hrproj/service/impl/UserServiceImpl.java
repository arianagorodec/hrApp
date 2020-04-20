package com.hrproj.service.impl;

import com.hrproj.entity.Candidate;
import com.hrproj.entity.Employee;
import com.hrproj.entity.User;
import com.hrproj.entity.enums.RoleEnum;
import com.hrproj.repository.CandidateRepository;
import com.hrproj.repository.EmployeeRepository;
import com.hrproj.repository.UserRepository;
import com.hrproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {


    @PersistenceContext
    private EntityManager em;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeServiceImpl employeeService;

//    @Autowired
//    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        if(user.getIdP().equals("0")){
            user.setRole(RoleEnum.ROLE_USER);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            //userRepository.save(user);

            Candidate candidate = new Candidate();
            candidate.setName(user.getName());
            candidate.setSurname(user.getSurname());
            candidate.setMobphone(user.getMobphone());
            candidate.setGender(user.getGender());
//            candidate.setBirthday(user.getBirthday());
            candidate.setEmail(user.getUsername());
            candidate.setUser(user);
            candidateRepository.save(candidate);
        }
        else {
            List<Employee> employeeList = employeeService.getAll();
            Employee employee = new Employee();
            String post = "";
            for (Employee e : employeeList) {
                if (e.getPasp_id().equals(user.getIdP())) {
                    post = e.getPost().getPost();
                    employee=new Employee(e);
                    break;
                }
            }
            if (!post.equals("")) {
                if (post.equals("HR")) {
                    user.setRole(RoleEnum.ROLE_ACCOUNTANT);
                } else {
                    user.setRole(RoleEnum.ROLE_WORKER);
                }
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                //userRepository.save(user);
                employee.setName(user.getName());
                employee.setSurname(user.getSurname());
                employee.setMobphone(user.getMobphone());
                employee.setGender(user.getGender());
//            employee.setBirthday(user.getBirthday());
              employee.setEmail(user.getUsername());
                employee.setUser(user);
                employeeRepository.save(employee);
            }
            else
                return false;
        }
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
        //if (userRepository.findById(userId)!=null) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }


    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getById_user(long id) {
        return userRepository.findById(id);
    }

    public boolean activatedUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if(user == null)
            return false;

//        user.setActivationCode(null);
        userRepository.save(user);

        return true;
    }

    public void saveActivatedUser(String code, String password) {

        User user = userRepository.findByActivationCode(code);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setActivationCode(null);
        userRepository.save(user);
    }

    //    @Override
//    public List<User> getAll() {
//        return userRepository.findAll();
//    }
}
