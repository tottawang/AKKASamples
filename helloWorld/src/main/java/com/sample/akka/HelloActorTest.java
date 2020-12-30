package com.sample.akka;

import org.junit.After;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.JavaTestKit;

public class HelloActorTest {

  private ActorSystem actorSystem;

  @org.junit.Before
  public void setUp() throws Exception {
    actorSystem = ActorSystem.create();
  }

  @After
  public void tearDown() throws Exception {
    JavaTestKit.shutdownActorSystem(actorSystem);
  }

  @Test
  public void testSayHello() throws Exception {
    new JavaTestKit(actorSystem) {
      {
        ActorRef helloActorRef = actorSystem.actorOf(HelloWorldActor.props());

        // not sure why I have to add sleep time, otherwise error is encountered: Message
        // [com.sample.akka.SayHello] from Actor was not delivered. [1] dead letters encountered.
        Thread.sleep(50);

        helloActorRef.tell(new SayHello(), ActorRef.noSender());
        helloActorRef.tell(new SayBye(), ActorRef.noSender());
      }
    };
  }
}
