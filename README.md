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
-constructor([new/0]).

methods.

new() -> ok.

append(L) ->
    L = list::new(),
    L.
```
###Generate Erlang native code.

```erlang
-module(list).

-export([append/2, new/0]).

append(ObjectID, L) -> L = list:new(), L.

new() -> ObjectID = ooe:new([]), ok, {list, ObjectID}.
```
