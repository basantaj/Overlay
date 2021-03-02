# Overlay
 Simple overlay panel that, given a text file, displays a sequence of images determined by a HashMap, set up for use on fighting games.

## Usage
Must be in a windowed or borderless windowed game to function properly. As far as I've researched, the tampering required to display a steam-like overlay would likely trigger anti-cheat measures. 

At the moment, the program reads a file named `combo.txt` in the `res` folder. Each input must be separated by a dash (`-`) for the program to process the text correctly.
The currently supported inputs(non case sensitive) are:

`fwd`,`bck` for forward/back inputs.

`dwn`,`up` for down/up inputs.

`df`,`db` for down-forward/down-back inputs.

`dp`,`dpb` for forward/back dragon punch inputs(623/421).

`hcf`,`hcb` for half-circle forward/back inputs(41236/63214).

`qcf`,`qcb` for fireball forward/back inputs(236/214).

`xx` often used to represent cancels.

`,` useful as a separator.

`lp,lk,mp,mk,hp,hk` for Street Fighter style button icons.

`A,B,C,D` for King of Fighters style button icons.
Both button sets have `cr` ,`j` and `cl` variants for close, jumping or crouching. Just add the corresponding letters at the start. `crLK`, for example.

So `jc-,-d-,-df-d-,-b-c-,-fwd-,-d-hcb-c-xx-qcf-qcf-d` will display as

![Alt Text](https://i.imgur.com/HnLP96j.png)

The program scans the file line by line and also  displays the icons line by line.

## Keyboard shortcuts

`ctrl + numpad_PLUS`: Panel opacity up.

`ctrl + numpad_MINUS`: Panel opacity down.

`ctrl + shift + numpad_PLUS`: Icon size up.

`ctrl + shift + numpad_MINUS`:Icon size down.

`ctrl + O`: Toggle panel visibility.

`ctrl + shift + Q`: Close program.


## Future improvements
If people seem interested, these are some features I thought about but didn't feel pressed to implement
* Better text processing(Less strict).
* Panel scaling and repositioning(At the moment the panel is always in the same place and the same size relative to screen resolution).
* More icons(360/Tiger knee input, dash, game specific mechanics, Guilty Gear buttons).
* Mixing text and icons(Some fighting game combos have specific nuances that would be infeasible to account for; allowing user text input is a decent compromise).
* User mapped icons(Allowing the user to add their own inputs and images to match them).
* User interface(For easier setup).

The current build is a bit lackluster but it's good enough for personal use.
