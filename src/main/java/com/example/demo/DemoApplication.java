package com.example.demo;

import com.example.demo.models.BlogPost;
import com.example.demo.models.Tag;
import com.example.demo.repository.BlogPostRepository;
import com.example.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    @Autowired
    BlogPostRepository blogPostRepository;

    @Autowired
    TagRepository tagRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");

        //Creating 3 blog posts
        BlogPost b = new BlogPost("how I became the strongest man on earth");
        BlogPost b1 = new BlogPost("The 3 downsides of being the most beautiful person in the room");
        BlogPost b2 = new BlogPost("How I basically secured world peace");

        System.out.println(b1.getId());
        System.out.println(b2.getId());

        //Creating 3 tags
        Tag t = new Tag("World news");
        Tag t2 = new Tag("Relevant4Everyone");
        Tag t3 = new Tag("GOAT");

        //Tagging some posts
        b.setTags(new HashSet<Tag>(Arrays.asList(t,t2)));
        b1.setTags(new HashSet<Tag>(Arrays.asList(t3)));

        blogPostRepository.saveAll(Arrays.asList(b,b1));
    }
}
