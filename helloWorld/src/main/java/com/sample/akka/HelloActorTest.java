package com.sample.akka;

import org.junit.Before;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class HelloActorTest {

  private ActorSystem actorSystem;

  @Before
  public void setUp() throws Exception {
    actorSystem = ActorSystem.create();
  }

  @Test
  public void testSayHello() throws Exception {
    ActorRef helloActorRef = actorSystem.actorOf(HelloWorldActor.props());
    Thread.sleep(50); // not sure if I need this to make messaging work
    helloActorRef.tell(new SayHello(), ActorRef.noSender());
    helloActorRef.tell(new SayBye(), ActorRef.noSender());
  }
}
