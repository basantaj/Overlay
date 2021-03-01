# Overlay
 Simple panel overlay que, dado un archivo de texto, muestra un hilo de imágenes determinado por un HashMap. Desarrollado para uso en video juegos de lucha.

## Uso
Debe usarse con aplicaciones en modo ventana o ventana sin borde. Según investigué, el manejo que tendría que hacerse para mostrar un overlay como el de Steam sería propenso a alertar medidas anti-cheat.

De momento, el programa lee un archivo llamado `combo.txt` en el directorio `res`. Cada input debe ser separado por un guión (`-`) para que el programa procese el texto correctamente.

Los inputs actualmente reconocidos son(no sensibles a mayúsculas):

 `fwd`,`bck` para adelante/atrás respectivamente.

 `dwn`,`up` para abajo/arriba respectivamente.

 `df`,`db` para abajo-adelante/abajo-atrás respectivamente.

 `dp`,`dpb` para movimiento de shoryuken(o en z) hacia adelante/atrás respectivamente(623/421).

 `hcf`,`hcb` para medio círculo hacia adelante/atrás respectivamente(41236/63214).

 `qcf`,`qcb` para cuarto de círculo hacia adelante/atrás respectivamente(236/214).

 `xx` frecuentemente se usa para representar cancelaciones.

 `,` útil como separador.

 `lp,lk,mp,mk,hp,hk` para íconos estilo Street Fighter.

`A,B,C,D` para íconos estilo King of Fighters.
Ambos grupos de botones tienen variantes `cr` ,`j` y `cl` para golpes agachados, en salto o cercanos respectivamente. Sencillamente se agrega el prefijo apropiado al principio. `crLK`, por ejemplo.

De modo que `jc-,-d-,-df-d-,-b-c-,-fwd-,-d-hcb-c-xx-qcf-qcf-d` se muestra como:
![Alt Text](https://i.imgur.com/HnLP96j.png)

El programa escanea el archivo de texto línea a línea y muestra las secuencias de íconos de la misma forma.

## Atajos de teclado 
`ctrl + numpad_PLUS`: Aumenta la opacidad del panel.

`ctrl + numpad_MINUS`: Disminuye la opacidad del panel.

`ctrl + shift + numpad_PLUS`: Aumenta el tamaño de los íconos.

`ctrl + shift + numpad_MINUS`:Disminuye el tamaño de los íconos

`ctrl + O`: Muestra/oculta el panel.

`ctrl + shift + Q`: Cierra el programa.


## Mejoras a futuro
Si la gente muestra interés, éstas son características que se me ocurrieron pero no sentí urgencia a implementarlas:
* Mejor procesamiento de texto(Menos estricto).
* Escalado y reubicación del panel(De momento el panel siempre es del mismo tamaño y está en la misma posición relativos a la resolución).
* Más íconos(360/Tiger knee, dash, mecánicas específicas de cada juego, botones de Guilty Gear).
* Mezclar texto e íconos(Algunos video juegos de lucha tienen detalles específicos que no serían razonables de implementar; permitir al usuario ingresar texto sería un buen punto medio).
* Íconos determinados por el usuario(Permitir al usuario agregar y mapear sus propios inputs e imágenes).
* Interfaz de usuario(Para facilitar el uso).

La build actual podría ser mejor pero es más que suficiente para uso personal.
