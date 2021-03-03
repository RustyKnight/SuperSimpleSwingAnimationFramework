# Super Simple Swing Animation Framework

Animation is kind of a passion for me.  Good animation is complicated, good animation is not a straight linear incremental path from point A to point B, good animation occurs over a period of time and includes basic animation theory/principles (anticipation, squash and stretch, etc, etc)

Swing wasn't designed for animation in mind, at least not like some of the other APIs that are available now days. This doesn't mean it can't be achieved, it just means you need to be prepared to do some hard work.

This is a super simple animation framework - if you're looking for a good animation framework, then use one of the other available frameworks. 

- [Universal Tween Engine](https://github.com/AurelienRibon/universal-tween-engine)
- [The TimingFramework](https://github.com/akuhtz/timingframework)
- [Trident](https://github.com/kirill-grouchnikov/radiance/blob/master/docs/trident/trident.md)

If you're looking to learn how those other frameworks "basically" work or just want to try building your own, then feel free to look inside

# Linear Animation

The framework provides for a concept of "linear" animation, which is typically used to perform simple, repetitive animation, like spin a wait icon.  The intention is to allow for an animation which doesn't have a defined "end" point, it just cycles until it's stopped.

# Duration Based Animation

Naive animators would attempt to animate the change of something from point A to point B using a linear delta.  That is, keep animating until your reach a desired state.  This is naive because it doesn't allow for low power systems, which would produce jumpy and staggered results.

Instead, a "duration" based animation should be used.  This means allowing the animation to play over a specific period of time and have the system provide "best effort" to render the state from the start to the end.

The framework has basic "duration" animatable concept, which simply provides a means to be alerted when the animation state has changed and obtain the amount of time, as a percentage, that the animation has been playing for.  You'd be surprised what you can do with this simple concept.

## Normalized time

The framework makes use of "normalized" time, this is, time values between 0 and 1.  This makes the framework highly flexible and dynamic.  Animation running to fast?  Change the duration, the framework will take care of the rest.

## Range Based Animation

A lot of the time, I spend animating from one point to another, over a period of time.  The "range" based animation provides for an abstracted approach to this problem.

Given a range of `A` to `B`, the framework can be used to calculate the `value` between them, over a normalized time frame, making it very simple to update the state simply by asking for the "current" value of the animator when the state of the animator changes.

# Timeline

Another use case I run into on a regular bases is "timelines".  A timeline is simply a normalized period of time, on which `KeyFrame`s reside at specific points along it.

The framework provides for both "Event" and "Blending" timelines

## `EventTimeline`

An event timeline provides the means to get all the events which occur at (about) a specific point along the timeline, from that, you can then perform other actions, like play other animations or sounds or what ever you need

## `BlendingTimeLine`

A blending timeline provides the means to calculate the value between two key frames along the timeline based on the position along the timeline

# Animation Curves

This framework makes use of a basic "easement" or "animation curve" API which provides a means to change the "progress" value of the animation over time, to add affects like ease-in/out. The API is simple, its implementation is based a "time" (normalized between 0-1) and the function returns back the modified "progress".  This is then used to calculate the current value for a specified range.

See
- [Easing functions](https://easings.net)
- [Robert Penner's Easing Functions](http://robertpenner.com/easing/)

for more details.

The project contains a simple test/example which provides a means to see the available easement functions and generally see how the API works
