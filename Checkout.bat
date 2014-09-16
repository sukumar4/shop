
@echo off

@echo SuperMarket Checkout Program
@echo ----------------------------

javac shop\*.java
java -cp . shop.ShoppingClient

@echo:

@echo "Press any key to close..."

pause >nul
