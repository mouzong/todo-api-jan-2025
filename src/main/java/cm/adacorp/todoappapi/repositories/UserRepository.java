package cm.adacorp.todoappapi.repositories;

import cm.adacorp.todoappapi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}