# Raktárkezelő

#### Olyan program, amelyben rögzíthető egy rendelés éskövethető a rendelkezésre álló készlet száma.

## A megnyitást választhatunk kettő opció közül.

##### Az első opció a felvétel gomb megnyomását követően egy rendelés felvétele. A vevő és a dátum mező áll azonnal rendelkezésre. A termék hozzáadása gomb megnyomásával termék mezőt tudunk hozzáadni, a termék törlése gombbal pedig törölni.

A rendelés leadásánal feltételei:

- ebben az évben lett leadva, vagyis az év csak a jelenlegi lehet, a hónap és nap maximum a jelenlegi.
- a termék neve helyesen lett megadva.
- a termékek darabszáma összesen nem haladja meg a 100-at.

##### A második opció a készlet ellenőrzése, ekkor a készlet elemeit, azok elérhető mennyiségét és az utolsó használat dátumát láthatjuk.

## Adatbázis

##### Az alkalmazás alapértelmezett adatbázisa:`default.json`

##### Az alkalmazás által használt adatbázis: `stock.sjon`

> A használat során a használt adatbázis frissül. 