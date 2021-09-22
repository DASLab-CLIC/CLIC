/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef NotifyService_H
#define NotifyService_H

#include <thrift/TDispatchProcessor.h>
#include <thrift/async/TConcurrentClientSyncInfo.h>
#include <memory>
#include "notify-service_types.h"

namespace clic {

#ifdef _MSC_VER
  #pragma warning( push )
  #pragma warning (disable : 4250 ) //inheriting methods via dominance 
#endif

class NotifyServiceIf {
 public:
  virtual ~NotifyServiceIf() {}
  virtual void postStatus(const std::string& jobName, const int32_t stageId, const StageSnapshot& stageSnapShot) = 0;
};

class NotifyServiceIfFactory {
 public:
  typedef NotifyServiceIf Handler;

  virtual ~NotifyServiceIfFactory() {}

  virtual NotifyServiceIf* getHandler(const ::apache::thrift::TConnectionInfo& connInfo) = 0;
  virtual void releaseHandler(NotifyServiceIf* /* handler */) = 0;
};

class NotifyServiceIfSingletonFactory : virtual public NotifyServiceIfFactory {
 public:
  NotifyServiceIfSingletonFactory(const ::std::shared_ptr<NotifyServiceIf>& iface) : iface_(iface) {}
  virtual ~NotifyServiceIfSingletonFactory() {}

  virtual NotifyServiceIf* getHandler(const ::apache::thrift::TConnectionInfo&) {
    return iface_.get();
  }
  virtual void releaseHandler(NotifyServiceIf* /* handler */) {}

 protected:
  ::std::shared_ptr<NotifyServiceIf> iface_;
};

class NotifyServiceNull : virtual public NotifyServiceIf {
 public:
  virtual ~NotifyServiceNull() {}
  void postStatus(const std::string& /* jobName */, const int32_t /* stageId */, const StageSnapshot& /* stageSnapShot */) {
    return;
  }
};

typedef struct _NotifyService_postStatus_args__isset {
  _NotifyService_postStatus_args__isset() : jobName(false), stageId(false), stageSnapShot(false) {}
  bool jobName :1;
  bool stageId :1;
  bool stageSnapShot :1;
} _NotifyService_postStatus_args__isset;

class NotifyService_postStatus_args {
 public:

  NotifyService_postStatus_args(const NotifyService_postStatus_args&);
  NotifyService_postStatus_args& operator=(const NotifyService_postStatus_args&);
  NotifyService_postStatus_args() : jobName(), stageId(0) {
  }

  virtual ~NotifyService_postStatus_args() noexcept;
  std::string jobName;
  int32_t stageId;
  StageSnapshot stageSnapShot;

  _NotifyService_postStatus_args__isset __isset;

  void __set_jobName(const std::string& val);

  void __set_stageId(const int32_t val);

  void __set_stageSnapShot(const StageSnapshot& val);

  bool operator == (const NotifyService_postStatus_args & rhs) const
  {
    if (!(jobName == rhs.jobName))
      return false;
    if (!(stageId == rhs.stageId))
      return false;
    if (!(stageSnapShot == rhs.stageSnapShot))
      return false;
    return true;
  }
  bool operator != (const NotifyService_postStatus_args &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const NotifyService_postStatus_args & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};


class NotifyService_postStatus_pargs {
 public:


  virtual ~NotifyService_postStatus_pargs() noexcept;
  const std::string* jobName;
  const int32_t* stageId;
  const StageSnapshot* stageSnapShot;

  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};


class NotifyService_postStatus_result {
 public:

  NotifyService_postStatus_result(const NotifyService_postStatus_result&);
  NotifyService_postStatus_result& operator=(const NotifyService_postStatus_result&);
  NotifyService_postStatus_result() {
  }

  virtual ~NotifyService_postStatus_result() noexcept;

  bool operator == (const NotifyService_postStatus_result & /* rhs */) const
  {
    return true;
  }
  bool operator != (const NotifyService_postStatus_result &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const NotifyService_postStatus_result & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};


class NotifyService_postStatus_presult {
 public:


  virtual ~NotifyService_postStatus_presult() noexcept;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);

};

class NotifyServiceClient : virtual public NotifyServiceIf {
 public:
  NotifyServiceClient(std::shared_ptr< ::apache::thrift::protocol::TProtocol> prot) {
    setProtocol(prot);
  }
  NotifyServiceClient(std::shared_ptr< ::apache::thrift::protocol::TProtocol> iprot, std::shared_ptr< ::apache::thrift::protocol::TProtocol> oprot) {
    setProtocol(iprot,oprot);
  }
 private:
  void setProtocol(std::shared_ptr< ::apache::thrift::protocol::TProtocol> prot) {
  setProtocol(prot,prot);
  }
  void setProtocol(std::shared_ptr< ::apache::thrift::protocol::TProtocol> iprot, std::shared_ptr< ::apache::thrift::protocol::TProtocol> oprot) {
    piprot_=iprot;
    poprot_=oprot;
    iprot_ = iprot.get();
    oprot_ = oprot.get();
  }
 public:
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> getInputProtocol() {
    return piprot_;
  }
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> getOutputProtocol() {
    return poprot_;
  }
  void postStatus(const std::string& jobName, const int32_t stageId, const StageSnapshot& stageSnapShot);
  void send_postStatus(const std::string& jobName, const int32_t stageId, const StageSnapshot& stageSnapShot);
  void recv_postStatus();
 protected:
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> piprot_;
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> poprot_;
  ::apache::thrift::protocol::TProtocol* iprot_;
  ::apache::thrift::protocol::TProtocol* oprot_;
};

class NotifyServiceProcessor : public ::apache::thrift::TDispatchProcessor {
 protected:
  ::std::shared_ptr<NotifyServiceIf> iface_;
  virtual bool dispatchCall(::apache::thrift::protocol::TProtocol* iprot, ::apache::thrift::protocol::TProtocol* oprot, const std::string& fname, int32_t seqid, void* callContext);
 private:
  typedef  void (NotifyServiceProcessor::*ProcessFunction)(int32_t, ::apache::thrift::protocol::TProtocol*, ::apache::thrift::protocol::TProtocol*, void*);
  typedef std::map<std::string, ProcessFunction> ProcessMap;
  ProcessMap processMap_;
  void process_postStatus(int32_t seqid, ::apache::thrift::protocol::TProtocol* iprot, ::apache::thrift::protocol::TProtocol* oprot, void* callContext);
 public:
  NotifyServiceProcessor(::std::shared_ptr<NotifyServiceIf> iface) :
    iface_(iface) {
    processMap_["postStatus"] = &NotifyServiceProcessor::process_postStatus;
  }

  virtual ~NotifyServiceProcessor() {}
};

class NotifyServiceProcessorFactory : public ::apache::thrift::TProcessorFactory {
 public:
  NotifyServiceProcessorFactory(const ::std::shared_ptr< NotifyServiceIfFactory >& handlerFactory) :
      handlerFactory_(handlerFactory) {}

  ::std::shared_ptr< ::apache::thrift::TProcessor > getProcessor(const ::apache::thrift::TConnectionInfo& connInfo);

 protected:
  ::std::shared_ptr< NotifyServiceIfFactory > handlerFactory_;
};

class NotifyServiceMultiface : virtual public NotifyServiceIf {
 public:
  NotifyServiceMultiface(std::vector<std::shared_ptr<NotifyServiceIf> >& ifaces) : ifaces_(ifaces) {
  }
  virtual ~NotifyServiceMultiface() {}
 protected:
  std::vector<std::shared_ptr<NotifyServiceIf> > ifaces_;
  NotifyServiceMultiface() {}
  void add(::std::shared_ptr<NotifyServiceIf> iface) {
    ifaces_.push_back(iface);
  }
 public:
  void postStatus(const std::string& jobName, const int32_t stageId, const StageSnapshot& stageSnapShot) {
    size_t sz = ifaces_.size();
    size_t i = 0;
    for (; i < (sz - 1); ++i) {
      ifaces_[i]->postStatus(jobName, stageId, stageSnapShot);
    }
    ifaces_[i]->postStatus(jobName, stageId, stageSnapShot);
  }

};

// The 'concurrent' client is a thread safe client that correctly handles
// out of order responses.  It is slower than the regular client, so should
// only be used when you need to share a connection among multiple threads
class NotifyServiceConcurrentClient : virtual public NotifyServiceIf {
 public:
  NotifyServiceConcurrentClient(std::shared_ptr< ::apache::thrift::protocol::TProtocol> prot, std::shared_ptr<::apache::thrift::async::TConcurrentClientSyncInfo> sync) : sync_(sync)
{
    setProtocol(prot);
  }
  NotifyServiceConcurrentClient(std::shared_ptr< ::apache::thrift::protocol::TProtocol> iprot, std::shared_ptr< ::apache::thrift::protocol::TProtocol> oprot, std::shared_ptr<::apache::thrift::async::TConcurrentClientSyncInfo> sync) : sync_(sync)
{
    setProtocol(iprot,oprot);
  }
 private:
  void setProtocol(std::shared_ptr< ::apache::thrift::protocol::TProtocol> prot) {
  setProtocol(prot,prot);
  }
  void setProtocol(std::shared_ptr< ::apache::thrift::protocol::TProtocol> iprot, std::shared_ptr< ::apache::thrift::protocol::TProtocol> oprot) {
    piprot_=iprot;
    poprot_=oprot;
    iprot_ = iprot.get();
    oprot_ = oprot.get();
  }
 public:
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> getInputProtocol() {
    return piprot_;
  }
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> getOutputProtocol() {
    return poprot_;
  }
  void postStatus(const std::string& jobName, const int32_t stageId, const StageSnapshot& stageSnapShot);
  int32_t send_postStatus(const std::string& jobName, const int32_t stageId, const StageSnapshot& stageSnapShot);
  void recv_postStatus(const int32_t seqid);
 protected:
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> piprot_;
  std::shared_ptr< ::apache::thrift::protocol::TProtocol> poprot_;
  ::apache::thrift::protocol::TProtocol* iprot_;
  ::apache::thrift::protocol::TProtocol* oprot_;
  std::shared_ptr<::apache::thrift::async::TConcurrentClientSyncInfo> sync_;
};

#ifdef _MSC_VER
  #pragma warning( pop )
#endif

} // namespace

#endif