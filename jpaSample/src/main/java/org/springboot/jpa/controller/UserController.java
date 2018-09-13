package org.springboot.jpa.controller;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springboot.jpa.entity.User;
import org.springboot.jpa.service.UsreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

//@Controller// 如果为RestController  会以json格式返回
@RestController
public class UserController {

	@Autowired UsreService userService;
	@RequestMapping("/")
	public String index() {
		return "redirect:/list";
		}
	
	@RequestMapping("/find")
	@Transactional
	/**
	 * page，第几页，从0开始，默认为第0页
	size，每一页的大小，默认为20
	sort，排序相关的信息，以property,property(,ASC|DESC)的方式组织，例如sort=firstname&sort=lastname,desc表示在按firstname正序排列基础上按lastname倒序排列。
	 */
	public Page<User> toAdd(int age,int page,int size) {
		//一般size都写死，只变page,即点上一页，下一页时调用该接口即可
		Sort sort = new Sort(Direction.DESC, "id");
	    Pageable pageable = new PageRequest(page, size, sort);
		 return userService.findByAge(age, pageable);
	}
	//获取springboot版本
	@RequestMapping("/getVersion")
	public static void getVersion() {
		System.out.println(SpringBootVersion.getVersion());;    // :: Spring Boot ::        (v2.0.4.RELEASE)
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<User> users = userService.getUserList();
		model.addAttribute("users", users);
		return "/list";
	}
	
	@RequestMapping("/getUser")
	public List getUser(Long userId) {
		return userService.getUserClass(userId);
	}
	@RequestMapping("/toEdit")
	public String toEdit(Model model,Long id) {
		Optional<User> user = userService.findUserById(id);
		model.addAttribute("uesr", user);
		return "/userEdit";
	}
	
	@RequestMapping("/delete")
	public String delete(Long id,String userName) {
		int i = userService.delByIdAndName(id,userName);
		if(i>0) {
			return "删除成功";
		}
		return "删除失败";
	}
}
