export function imageFromMediaStream(mediaStream) {
  return new Promise((resolve, reject) => {
    const mediaRecorder = new MediaRecorder(mediaStream);
    mediaRecorder.ondataavailable = (event) => {
      resolve(event.data);
    };
    mediaRecorder.start(900);
    setTimeout(() => mediaRecorder.stop(), 1000);
  });
}
