# Adapter
## Ausgangslage
Unsere Anwendung ist Gewachsen. Wir sollen jetzt auch Truthähne unterstützen.

Das Turkey Interface verfügt über die Methoden fly und gobble.

## Problem
Die Truthähne wurden von einer externen Firma entwickelt. Es ist uns nicht möglich den Quelltext zu bearbeiten.

Die API der Truthähne unterscheidet sich von unserer. Außerdem kann unsere Vererbungshirachie nicht genutzt werden.

Das Flugverhalten ist anders. Wenn ein Truthahn fliegt muss der fly aufruf 5 mal geschehen.