
#import "RNScheduleAlarm.h"

@implementation RNScheduleAlarm


- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()


RCT_EXPORT_METHOD(schedule: (NSInteger) scheduledAt title:(NSString *) title description: (NSString *) description soundUri: (NSString *) soundUri)
{
    UNUserNotificationCenter* center = [UNUserNotificationCenter currentNotificationCenter];
    UNAuthorizationOptions options = UNAuthorizationOptionAlert + UNAuthorizationOptionSound;
    [center requestAuthorizationWithOptions:options
         completionHandler:^(BOOL granted, NSError * _Nullable error) {
                              if (!granted) {
                                  NSLog(@"Something went wrong");
                              }
    }];

    UNMutableNotificationContent *content = [UNMutableNotificationContent new];
    content.title = title;
    content.body = description;
    content.sound = [UNNotificationSound soundNamed: soundUri];
    UNTimeIntervalNotificationTrigger *trigger = [UNTimeIntervalNotificationTrigger triggerWithTimeInterval:scheduledAt repeats:NO];                                                     
    NSString *identifier = @"UYLLocalNotification";
    UNNotificationRequest *request = [UNNotificationRequest requestWithIdentifier:identifier  content:content trigger:trigger];
                                                                         
    [center addNotificationRequest:request withCompletionHandler:^(NSError * _Nullable error) {
        if (error != nil) {
            NSLog(@"Something went wrong: %@",error);
        }
    }];
}
@end
