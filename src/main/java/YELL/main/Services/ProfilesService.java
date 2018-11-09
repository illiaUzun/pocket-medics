package YELL.main.Services;

import YELL.main.Repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilesService {

    @Autowired
    ProfileRepository repository;


}
