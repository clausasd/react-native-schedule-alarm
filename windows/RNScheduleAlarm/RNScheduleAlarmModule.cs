using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Schedule.Alarm.RNScheduleAlarm
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNScheduleAlarmModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNScheduleAlarmModule"/>.
        /// </summary>
        internal RNScheduleAlarmModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNScheduleAlarm";
            }
        }
    }
}
