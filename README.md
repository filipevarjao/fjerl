=====
Fjerl
=====

Fjerl is a compiler (maybe just a translator) from Featherweight Java approach to ooErlang and consequently Erlang. This project show the idea of relationship between Object-Orientation and Message Passing, strengthening the first thought of OO created by Dr. Alan Kay, mapping Java objects directly to Erlang process.

### Requirements
* Antlr 4 and ooErlang

Example in Featherweight Java 
-------------
```fjava
class List extends Object {
    List() { super(); }
    List append(List l) {
      return this;
    }
}
```
Compiled to ooErlang
-------------
```ooerlang
-class(list).
-export([append/0]).
-constructor([constructor/0]).

methods.

constructor() -> ok.

append() ->
    L = list::constructor(),
    L.
```
Generate Erlang native code.
-------------
```erlang
-module(list).

-export([append/1, constructor/0]).

append(ObjectID) -> L = list:constructor(), L.

constructor() ->
    ObjectID = ooe:new([]), ok, {list, ObjectID}.
```
