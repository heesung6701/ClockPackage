package com.quokkaman.android.app.common.data

data class AlarmVibrate(override val active: Boolean, val type: Type) : AlarmSetting(active) {
    
    override fun getTitle(): String = "진동"

    override fun getSummaryOn(): String = type.name
    
    public enum class Type(name: String) {
        BasicCall("Basic call"),
        Heartbeat("Heartbeat"),
        Ticktock("Ticktock"),
        Waltz("Waltz"),
        ZigZigZig("Zig-zig-zig"),
        Offbeat("Off-beat"),
        Spinning("Spinning"),
        Siren("Siren"),
        Telephone("Telephone"),
        Ripple("Ripple"),
        Bounce("Bounce"),
        Tap("TAp"),
        Dubstep("Dubstep"),
        Fireworks("Fireworks"),
        Gallop("Gallop"),
        Shuffle("shuffle"),
        Spring("Spring");
    }
}

