# Last Pencil (Java)

Simple console game written in **Java** where two players take turns removing pencils from a pile.  
Each player can take **1, 2, or 3 pencils** per turn.  
The player who takes the **last pencil loses**.

One of the players can be a **bot that follows a winning strategy**.

---

## Game Rules

- The game starts with **N pencils** on the table.
- Two players participate:
  - **John (human)**
  - **Jack (bot)**
- Each turn a player can remove:
  - `1`, `2`, or `3` pencils
- The player who takes the **last pencil loses the game**.

---

## Bot Strategy

The bot uses a simple mathematical strategy:

- If the number of pencils is in a **losing position**  
  `(1, 5, 9, 13...)` → it chooses a random number.

- Otherwise, it removes the correct amount of pencils to leave the opponent in a losing position.

Example losing positions:

```
1
5
9
13
17
```

---

## Example Gameplay

```
How many pencils would you like to use:
10

Who will be the first (John, Jack):
John

||||||||||

John's turn:
2

||||||||

Jack's turn:
3
```

---

## Input Validation

The program validates user input:

If the number of pencils is not numeric:

```
The number of pencils should be numeric
```

If the number is zero or negative:

```
The number of pencils should be positive
```

If the player enters an invalid move:

```
Possible values: '1', '2' or '3'
```

---

## Technologies

- Java
- Console input/output
- Basic game logic
- Simple AI strategy

---

## How to Run

Clone the repository:

```bash
git clone https://github.com/royaimo/Last-Pencil-Java.git
```

Compile:

```bash
javac Main.java
```

Run:

```bash
java lastpencil.Main
```

---

## Project Source

https://github.com/royaimo/Last-Pencil-Java
