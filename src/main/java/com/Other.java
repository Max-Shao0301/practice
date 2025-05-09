public class GenderCountDTO {
    private String gender;
    private Long count;

    public GenderCountDTO(String gender, Long count) {
        this.gender = gender;
        this.count = count;
    }

    public String getGender() {
        return gender;
    }

    public Long getCount() {
        return count;
    }
}

public interface UserRepository extends JpaRepository<UserVO, Integer> {

    @Query(
        value = "SELECT gender, COUNT(*) AS count FROM user GROUP BY gender",
        nativeQuery = true)
    List<Object[]> countUsersGroupByGender();
}

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<GenderCountDTO> getGenderStatistics() {
        List<Object[]> rawResults = userRepository.countUsersGroupByGender();
        List<GenderCountDTO> result = new ArrayList<>();

        for (Object[] row : rawResults) {
            String gender = (String) row[0];
            Long count = ((Number) row[1]).longValue();  // 防止轉型錯誤
            result.add(new GenderCountDTO(gender, count));
        }

        return result;
    }
}

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/gender-stats")
    public String showGenderStats(Model model) {
        List<GenderCountDTO> stats = userService.getGenderStatistics();
        model.addAttribute("genderStats", stats);
        return "user/gender_stats";  // 指向 Thymeleaf 模板
    }
}

<!-- templates/user/gender_stats.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>使用者性別統計</title>
</head>
<body>
    <h2>性別統計</h2>
    <table border="1">
        <tr>
            <th>性別</th>
            <th>人數</th>
        </tr>
        <tr th:each="stat : ${genderStats}">
            <td th:text="${stat.gender}">性別</td>
            <td th:text="${stat.count}">人數</td>
        </tr>
    </table>
</body>
</html>
