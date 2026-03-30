package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.*;
import com.sprint.mission.discodeit.service.jcf.*;

public class JavaApplication {
    public static void main(String[] args) {
        UserService userService = new JCFUserService();
        ChannelService channelService = new JCFChannelService();
        MessageService messageService = new JCFMessageService();

        System.out.println("----------------사용자 테스트 시작!!!------------------");
        // CREATE
        System.out.println("- UserCreate \t\t: .create()");
        User user1 = new User("user1", "user1@email.com", "1234", "test1");
        userService.create(user1);
        User user2 = new User("user2", "user2@email.com", "5678", "test2");
        userService.create(user2);
        User user3 = new User("user3", "user3@email.com", "9101", "test3");
        userService.create(user3);
        User user4 = new User("user4", "user4@email.com", "1121", "test4");
        userService.create(user4);
        User user5 = new User("user5", "user5@email.com", "3141", "test5");
        userService.create(user5);
        User user6 = new User("user6", "user6@email.com", "5161", "test6");
        userService.create(user6);
        // READ
        System.out.println("- UserRead \t\t\t: .findById(user3.getId())");
        userService.findById(user3.getId()).ifPresent(it -> System.out.println("\t" + it));
        System.out.println("- UserRead \t\t\t: .findAll()");
        userService.findAll().ifPresent(list -> list.forEach(it -> System.out.println("\t" + it)));
        // UPDATE
        System.out.println("- UserUpdate \t\t: .updateById(user4.getId())");
        userService.updateById(user4.getId(), "test4_updated", user4.getEmail(), user4.getPassword(), user4.getNickname());
        System.out.println("- UserRead \t\t\t: .findById(user4.getId())");
        userService.findById(user4.getId()).ifPresent(it -> System.out.println("\t" + it));
        // DELETE
        System.out.println("- UserDelete \t\t: .deleteById(user6.getId())");
        userService.deleteById(user6.getId());
        System.out.println("- UserRead \t\t\t: .findById(user6.getId())");
        userService.findById(user6.getId()).ifPresentOrElse(
                it -> System.out.println("\t" + it),
                () -> System.out.println("\tRead 결과 없음(NULL)")
        );
        System.out.println("----------------사용자 테스트 끝!!!--------------------\n");



        System.out.println("----------------채널 테스트 시작!!!------------------");
        // CREATE
        System.out.println("- ChannelCreate \t: .create()");
        Channel channel1 = new Channel("channel1", "thisischannel1", user1);
        channelService.create(channel1);
        Channel channel2 = new Channel("channel2", "thisischannel2", user3);
        channelService.create(channel2);
        Channel channel3 = new Channel("channel3", "thisischannel3", user5);
        channelService.create(channel3);
        // READ
        System.out.println("- ChannelRead \t\t: .findById(channel1.getId())");
        channelService.findById(channel1.getId()).ifPresent(it -> System.out.println("\t" + it));
        System.out.println("- ChannelRead \t\t: .findAll()");
        channelService.findAll().ifPresent(list -> list.forEach(it -> System.out.println("\t" + it)));
        // UPDATE
        System.out.println("- ChannelUpdate \t: .updateById(channel3.getId())");
        channelService.updateById(channel3.getId(), "channel3_updated", channel3.getDescription(), channel3.getOwner());
        System.out.println("- ChannelRead \t\t: .findById(channel3.getId()");
        channelService.findById(channel3.getId()).ifPresent(it -> System.out.println("\t" + it));
        System.out.println("- ChannelUpdate \t: .addUser(channel1.getId(), user2)");
        channelService.addUser(channel1.getId(), user2);
        System.out.println("- ChannelUpdate \t: .addUser(channel2.getId(), user4)");
        channelService.addUser(channel2.getId(), user4);
        System.out.println("- ChannelUpdate \t: .deleteUser(channel2.getId(), user4");
        channelService.deleteUser(channel2.getId(), user4);
        System.out.println("- ChannelUpdate \t: .deleteUser(channel3.getId(), user5");
        // DELETE
        System.out.println("- ChannelDelete \t: .deleteById(channel3.getId()");
        channelService.deleteById(channel3.getId());
        System.out.println("----------------채널 테스트 끝!!!--------------------\n");



        System.out.println("----------------메시지 테스트 시작!!!-------------------");
        // CREATE
        System.out.println("- MessageCreate \t: .create()");
        Message message1 = new Message("thisismessage1", user1);
        messageService.create(message1);
        System.out.println("- ChannelUpdate \t: .addMessage(channel1.getId(), message1)");
        channelService.addMessage(channel1.getId(), message1);
        Message message2 = new Message("thisismessage2", user2);
        messageService.create(message2);
        System.out.println("- ChannelUpdate \t: .addMessage(channel1.getId(), message2)");
        channelService.addMessage(channel1.getId(), message2);
        Message message3 = new Message("thisismessage3", user3);
        messageService.create(message3);
        System.out.println("- ChannelUpdate \t: .addMessage(channel2.getId(), message3)");
        channelService.addMessage(channel2.getId(), message3);
        // READ
        System.out.println("- MessageRead\t\t: .findById(message1.getId())");
        messageService.findById(message1.getId()).ifPresent(it -> System.out.println("\t"+ it));
        System.out.println("- MessageRead\t\t: .findBySendUser(user1)");
        messageService.findBySendUser(user1).ifPresent(list -> list.forEach(it -> System.out.println("\t" + it)));
        System.out.println("- MessageRead\t\t: .findAll()");
        messageService.findAll().ifPresent(list -> list.forEach(it -> System.out.println("\t" + it)));
        // UPDATE
        System.out.println("- MessageUpdate\t\t: .updateById(message3.getId())");
        messageService.updateById(message3.getId(), "thisismessage3+updated");
        System.out.println("- MessageRead\t\t: .findById(message3.getId())");
        messageService.findById(message3.getId());
        // DELETE
        System.out.println("- MessageDelete\t\t: .deleteById(message2.getId())");
        messageService.deleteById(message2.getId());
        System.out.println("- ChannelUpdate \t: .deleteMessage(channel1.getId(), message2)");
        channelService.deleteMessage(channel1.getId(), message2);
        System.out.println("- MessageRead\t\t: .findById(message2.getId())");
        messageService.findById(message2.getId());
        System.out.println("----------------메시지 테스트 끝!!!---------------------\n");



        System.out.println("----------------의존성 테스트 시작!!!------------------");
        // CREATE
        System.out.println("- UserCreate \t\t: 의존성 없음");
        System.out.println("- ChannelCreate\t\t: User(owner) 필요");
        System.out.println("\tUserCreate : .create()");
        User user7 = new User("user7", "user7@email.com", "7181", "test7");
        userService.create(user7);
        User user8 = new User("user8", "user8@email.com", "9202", "test8");
        userService.create(user8);
        System.out.println("\tChannelCreate : .create()");
        Channel channel4 = new Channel("channel4", "thisischannel4", user7);
        channelService.create(channel4);
        System.out.println("- MessageCreate\t\t: User(sendUser), ChannelService.addMessage() 필요");
        System.out.println("\tMessageCreate : .create()");
        Message message4 = new Message("thisismessage4", user7);
        messageService.create(message4);
        System.out.println("\tChannelUpdate : .addMessage()");
        channelService.addMessage(channel4.getId(), message4);
        System.out.println("\tMessageCreate : .create()");
        Message message5 = new Message("thisismessage5", user7);
        messageService.create(message5);
        System.out.println("\tChannelUpdate : .addMessage()");
        channelService.addMessage(channel2.getId(), message5);
        // READ
        System.out.println("- UserRead \t\t\t: 의존성 없음");
        System.out.println("- ChannelRead\t\t: 의존성 없음");
        System.out.println("- MessageRead\t\t: 의존성 없음");
        // UPDATE
        System.out.println("- UserUpdate \t\t: 의존성 없음");
        System.out.println("- ChannelUpdate\t\t: 의존성 없음");
        channelService.addUser(channel4.getId(), user8);
        System.out.println("- MessageUpdate\t\t: 의존성 없음");
        // DELETE
        System.out.println("- UserDelete \t\t: ChannelService.deleteUser() 필요");
        System.out.println("\tUserDelete : .deleteById()");
        userService.deleteById(user7.getId());
        System.out.println("\tChannelUpdate : .deleteUser()");
        channelService.deleteUser(channel4.getId(), user7);
        System.out.println("- ChannelDelete\t\t: MessageService.deleteById() 필요");
        System.out.println("\tChannelRead : .findById()");
        System.out.println("\tMessageDelete : .deleteById()");
        channelService.findById(channel4.getId()).ifPresent(channel -> channel.getMessageList().forEach(message -> messageService.deleteById(message.getId())));
        System.out.println("\tChannelDelete : .deleteById()");
        channelService.deleteById(channel4.getId());
        System.out.println("- MessageDelete\t\t: ChannelService.deleteMessage() 필요");
        System.out.println("\tChannelUpdate : .deleteMessage()");
        channelService.deleteMessage(channel2.getId(), message3);
        System.out.println("\tMessageDelete : .deleteById()");
        messageService.deleteById(message3.getId());
        System.out.println("----------------의존성 테스트 끝!!!--------------------\n");
    }
}
