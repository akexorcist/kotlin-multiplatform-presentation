#import <UIKit/UIKit.h>
#import <AVFoundation/AVFoundation.h>

@interface IOPreviewView : UIView

@property (nonatomic, readonly) AVCaptureVideoPreviewLayer *videoPreviewLayer;

@property (nonatomic, weak) AVCaptureSession *session;

@end
