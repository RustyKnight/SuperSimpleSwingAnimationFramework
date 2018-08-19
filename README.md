# Super Simple Swing Animation Framework

Animation is kind of a passion for me.  Good animation is complicated, good animation is not a straight linear incremental path from point A to point B, good animation occurs over a period of time and includes basic animation theory/principles (anticaption, squash and stretch, etc, etc)

Swing wasn't design for animation in mind, at least not some of the other APIs that are avaliable now days. This doesn't mean it can't be achieved, it just means you need to be prepared to do some hard work.

This is a super simple animtion framework - if you're looking a good animation framework, then use one of the other avaliable frameworks. 

- [Universal Tween Engine](https://github.com/AurelienRibon/universal-tween-engine)
- [The TimingFramework](https://github.com/akuhtz/timingframework)
- [Trident](https://github.com/kirill-grouchnikov/radiance/blob/master/docs/trident/trident.md)

If you're looking to learn how those other frameworks "basically" work or just want to try building your own, then feel free to look inside

This framework makes use of a basic "easement" API which provides a means to change the "progress" value of the animation over time, to add affects like ease-in/out. The API is simple, it implementation is based a "time" (normalized bewteen 0-1) and the function returns back the modified "progress".  This is then used to calculate the current value for a specified range.

See
- [Easing functions](https://easings.net)
- [Robert Penner's Easing Functions](http://robertpenner.com/easing/)

for more details.

The project contains a simple test/example which provides a means to see the avaliable easement functions and generally see how the API works