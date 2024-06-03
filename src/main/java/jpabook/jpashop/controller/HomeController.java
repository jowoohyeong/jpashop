package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;
    private final ItemService itemService;


    @RequestMapping("/")
    public String home(){
        log.info("home controller");
        return "home";
    }

    @RequestMapping("/init")
    public String init(){

        Address address = new Address("도시", "거리", "우편번호");
        Member member = Member.createMember("jwh", address);

        memberService.join(member);

        Book item = Book.createBook("상품", "isbn", "저자", 1000, 10);
        itemService.saveItem(item);
        return "redirect:/";
    }
}
