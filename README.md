=====
Fjerl
=====

Fjerl is a compiler (maybe just a translator) from Featherweight Java approach to ooErlang and consequently Erlang. This project show the idea of relationship between Object-Orientation and Message Passing, strengthening the first thought of OO created by Dr. Alan Kay, mapping Java objects directly to Erlang process.

### Requirements
* Antlr 4 and ooErlang

Example
-------
###Featherweight Java 
```java
class List extends Object {
    List() { super(); }
    List append(List l) {
      return this;
    }
}
```
###Compiled to ooErlang
```erlang
-class(list).
-export([append/1]).
-constructor([new/1]).

methods.

new() -> ok.

append(L) ->
    self::new().
```
###Generate Erlang native code.

```erlang
-module(list).

-export([append/2, new/1]).

append(ObjectID, L) -> new(ObjectID).

new(ObjectID) ->  ok.
```
