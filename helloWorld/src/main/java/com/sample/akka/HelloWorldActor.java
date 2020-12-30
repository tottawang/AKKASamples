package com.sample.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

/**
 * https://riptutorial.com/akka/example/23198/akka-hello-world- more -java-8- just create a simple
 * program to run and see how Actor works in AKKA framework, more complex samples to create
 *
 */
public class HelloWorldActor extends AbstractActor {

  public HelloWorldActor() {
    receive(ReceiveBuilder.match(SayHello.class, this::sayHello).match(SayBye.class, this::sayBye)
        .build());
  }

  private void sayHello(final SayHello message) {
    System.out.println("Hello World");
  }

  private void sayBye(final SayBye message) {
    System.out.println("Bye World");
  }

  public static Props props() {
    return Props.create(HelloWorldActor.class);
  }
}
