#import <UIKit/UIKit.h>
#import <AVFoundation/AVFoundation.h>

@interface IOPreviewView : UIView

@property (nonatomic, readonly) AVCaptureVideoPreviewLayer *videoPreviewLayer;

@property (nonatomic, weak) AVCaptureSession *session;

+ (Class)layerClass;

@end

@implementation IOPreviewView

- (AVCaptureVideoPreviewLayer *)videoPreviewLayer {
  if (![self.layer isKindOfClass:[AVCaptureVideoPreviewLayer class]]) {
//    @fatalError(@"Expected AVCaptureVideoPreviewLayer type for layer. Check IOPreviewView.layerClass implementation.");
      NSAssert([self.layer isKindOfClass:[AVCaptureVideoPreviewLayer class]], @"Expected AVCaptureVideoPreviewLayer type for layer. Check IOPreviewView.layerClass implementation.");
  }
  return (AVCaptureVideoPreviewLayer *)self.layer;
}

- (AVCaptureSession *)session {
  return self.videoPreviewLayer.session;
}

- (void)setSession:(AVCaptureSession *)session {
  self.videoPreviewLayer.session = session;
}

+ (Class)layerClass {
  return [AVCaptureVideoPreviewLayer class];
}

@end
