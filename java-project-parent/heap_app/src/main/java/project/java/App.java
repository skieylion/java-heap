package project.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;


public class App {
    public static void main(String[] args) {

        User user1 = new User(1L, "Иванов", "Директор");
        User user2 = new User(1L, "Иванов2", "Директор");
        User user3 = new User(1L, "Иванов3", "Директор");
        List<User> users = Optional.of(Arrays.asList(new UserTask(user1), new UserTask(null), new UserTask(user3))).orElse(new ArrayList<>()).stream()
                .map(UserTask::getAssignee)
                .filter(Objects::nonNull)
                .filter(user -> Objects.nonNull(user.getFullName()))
                .filter(user -> Objects.nonNull(user.getPosition()))
                .collect(ArrayList::new, (userList, user) -> {
                    userList.stream()
                            .filter(u -> Objects.equals(user.getId(), u.getId()))
                            .findFirst()
                            .ifPresent(userList::remove);
                    userList.add(user);
                }, ArrayList::addAll);
        System.out.println(users);
    }
}


@Data
@AllArgsConstructor
class User {
    Long id;
    String fullName;
    String position;
}

@Data
@AllArgsConstructor
class UserTask {
    User assignee;
}